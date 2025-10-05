<div align="center">

# Lox Programming Language

-- My implementations for Crafting Interpreteres by Bob Nystorm -- 

</div>

## TODO

- [x] main function that runs the REPL and Compiler
- [x] Data Structure for the lexemes (Token and TokenType enum)
- [x] scanner
- [ ] parser
- [ ] compiler

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

3. Make sure you have [Apache Maven](https://maven.apache.org/install.html) available on your `PATH`.

4. Compile using the given script (wraps `mvn clean compile`):

```bash
./compile.sh
```

5. Run using the given script (re-compiles and launches the AST printer for now):

```bash
./run.sh
```
