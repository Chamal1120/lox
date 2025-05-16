<div align="center">

# Lox Programming Language

-- My implementations for Crafting Interpreteres by Bob Nystorm -- 

</div>

## TODO

[x] main function that runs the REPL and Compiler
[x] Data Structure for the lexemes (Token and TokenType enum)
[x] scanner
[] parser
[] compiler

> [!NOTE]
> Things might change here coz I'm still following this book.

## How to run

1. Clone repo (Duh..!)

2. Create a `test.lox` file:

```
print "Hello, Lox!";

true;  // Not false.
false; // Not *not* false.

1234;  // An integer.
12.34; // A decimal number.

"I am a string";
"";    // The empty string.
"123"; // This is a string, not a number.

a = 1;
b = 2;
c = a + b;
d = a / b;

print c;
print d;
```

2. Compile using the given script:

```bash
./compile.sh
```

3. Run using the given script:

```bash
./run.sh
```
