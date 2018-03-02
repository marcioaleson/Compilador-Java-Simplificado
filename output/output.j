.class public Main
.super java/lang/Object

; standard initializer
.method public <init>()V
  aload_0
  invokenonvirtual java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava/lang/String;)V
.limit stack 100
.limit locals 100

ldc 0.0
fstore 0
ldc 0.0
fstore 1
ldc 0.0
fstore 2

ldc 0.0
fstore 3

ldc 2
fstore 3

ldc 10
fstore 0

ldc 7
fstore 1

new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
astore_0
aload_0
invokevirtual java/util/Scanner/nextFloat()F
fstore_0

new java/util/Scanner
dup
getstatic java/lang/System/in Ljava/io/InputStream;
invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
astore_1
aload_1
invokevirtual java/util/Scanner/nextFloat()F
fstore_1


fconst_10
fconst_7
fadd
fconst_2
fdiv

fstore 2

getstatic java/lang/System/out Ljava/io/PrintStream;
ldc 0
invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V


.end method
