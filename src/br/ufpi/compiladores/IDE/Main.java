package br.ufpi.compiladores.IDE;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

import br.ufpi.compiladores.acoessematicas.AcoesSemanticas;
import br.ufpi.compiladores.calculos.GeradorCalculos;
import br.ufpi.compiladores.erro.ErroSintaxeException;
import br.ufpi.compiladores.erro.ErroSintaxeListener;
import br.ufpi.compiladores.jasmin.GeradorJasmin;
import br.ufpi.compiladores.semantica.GramaticaLexer;
import br.ufpi.compiladores.semantica.GramaticaParser;
import br.ufpi.compiladores.semantica.GramaticaParser.ProgramContext;

public class Main extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private final RSyntaxTextArea textArea;
    private final JTextArea caixaText;
    private final JTextField searchField;
    private final JCheckBox regexCB;
    private final JCheckBox matchCaseCB;
    private final JToolBar toolBar, toolBarFoot;
	private String codigo = "";
	private String errosResultados = "";
	private ErroSintaxeListener syntaxError;
	private AcoesSemanticas semantica;
	private GeradorCalculos calculos;
	private GramaticaLexer lexer;
	private CommonTokenStream tokens;
	private GramaticaParser parser;
	private ProgramContext tree;
	private String entrada;
	private ANTLRInputStream stream;
    //private final JButton compilar; 
    public Main() {
        JPanel cp = new JPanel(new BorderLayout());
		textArea = new RSyntaxTextArea(20, 60);
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		textArea.setCodeFoldingEnabled(true);
		textArea.setAntiAliasingEnabled(true);
		RTextScrollPane sp = new RTextScrollPane(textArea);
        sp.setFoldIndicatorEnabled(true);
        
        cp.add(sp);
        //Cria o toolbar: Topo
        toolBar = new JToolBar();
        //Cria campo de busca
        searchField = new JTextField(30);
        toolBar.add(searchField);
        //Cria botao "Buscar Proximo"
        final JButton nextButton = new JButton("Buscar Proximo");
        nextButton.setActionCommand("FindNext");
        nextButton.addActionListener(this);
        toolBar.add(nextButton);
        searchField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextButton.doClick(0);
            }
        });
        toolBar.addSeparator();
        //Cria botao "Buscar Anterior"
        JButton prevButton = new JButton("Buscar Anterior");
        prevButton.setActionCommand("FindPrev");
        prevButton.addActionListener(this);
        toolBar.add(prevButton);
        toolBar.addSeparator();
        //Cria botao "Compilar"
        JButton compButton = new JButton("Compilar");
        compButton.setActionCommand("Compilar");
        compButton.addActionListener(this);
        toolBar.add(compButton);
        
        regexCB = new JCheckBox("Não Case");
        toolBar.add(regexCB);
        matchCaseCB = new JCheckBox("Case");
        toolBar.add(matchCaseCB);
        
        cp.add(toolBar, BorderLayout.NORTH);
        toolBarFoot = new JToolBar();
        caixaText = new JTextArea(6,2);
        toolBarFoot.add(new JScrollPane(caixaText));
        cp.add(toolBarFoot, BorderLayout.SOUTH);        
        setContentPane(cp);
        setTitle("Compilador");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //"Compilar"
        String command = e.getActionCommand();
        if ("Compilar".equals(command)) {
            entrada = textArea.getText().toString();
			stream = new ANTLRInputStream(entrada);
            lexer = new GramaticaLexer(stream);
            tokens = new CommonTokenStream(lexer);
            //Sintatico
            parser = new GramaticaParser(tokens);
            //Erro
            parser.removeErrorListeners();
            syntaxError = new ErroSintaxeListener();
            parser.addErrorListener(syntaxError);
            tree = parser.program();            
            
        
            //Semântica
            ParseTreeWalker walker = new ParseTreeWalker();
            semantica = new AcoesSemanticas(parser);
            walker.walk(semantica, tree);
            
        errosResultados = "";
        caixaText.setText("");
        if (!syntaxError.getErroSintaxe().isEmpty()) {
		for (ErroSintaxeException erro : syntaxError.getErroSintaxe()) {
                    errosResultados+=erro.toString();
                }
            }
        if(!semantica.getErros().isEmpty()){
            for (String erro : semantica.getErros()) {
            	errosResultados+=erro;
            }
        }
        
        if(errosResultados.isEmpty()){
        	 //Jasmin
            GeradorJasmin jasmin = new GeradorJasmin();
            codigo += createJasminFile(jasmin.visit(tree));
            codigo+=jasmin.getFuncoesPrograma();
            
            //Salvando em Arquivo.
            try {
				FileWriter bytecode = new FileWriter("output/output.j");
				bytecode.write(codigo);
				bytecode.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
            
            //Limpando
            codigo = "";
            
            
            //Calculos
            calculos = new GeradorCalculos();
            codigo+=calculos.visit(tree) == null?"":calculos.visit(tree);
            
            caixaText.setText(codigo);
            
            //Limpando
            codigo = "";
     	
        }else{
            caixaText.setText(errosResultados);
            //Limpando
            errosResultados="";        	
        }

        }

        boolean forward = "FindNext".equals(command);
        // Create an object defining our search parameters.
        SearchContext context = new SearchContext();
        String text = searchField.getText();
        if (text.length() == 0) {
            return;
        }
        context.setSearchFor(text);
        context.setMatchCase(matchCaseCB.isSelected());
        context.setRegularExpression(regexCB.isSelected());
        context.setSearchForward(forward);
        context.setWholeWord(false);

        boolean found = SearchEngine.find(textArea, context);
        if (!found) {
            JOptionPane.showMessageDialog(this, "Erro não encontrado!");
        }
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {    
            @Override
            public void run() {
                try {
                    String laf = UIManager.getSystemLookAndFeelClassName();
                    UIManager.setLookAndFeel(laf);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                Main demo = new Main();
                demo.setVisible(true);
                demo.textArea.requestFocusInWindow();
            }
        });
    }
    
    public static String createJasminFile(String stmt){
        return ".class public Main\n" +
            ".super java/lang/Object\n" +
            "\n" +
            "; standard initializer\n" +
            ".method public <init>()V\n" +
            "  aload_0\n" +
            "  invokenonvirtual java/lang/Object/<init>()V\n"+
            "  return\n" +
            ".end method\n\n" +
            ".method public static main([Ljava/lang/String;)V\n" +
            ".limit stack 100\n" +
            ".limit locals 100\n" +
            "\n" +
            stmt + "\n" +
            ".end method" + "\n";
    }
}
