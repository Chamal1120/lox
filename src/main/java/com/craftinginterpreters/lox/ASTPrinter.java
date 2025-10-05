package com.craftinginterpreters.lox;

// Visitor for pritty printing the tree: implements Visitor
class AstPrinter implements Expr.Visitor<String> {

  // Visit the perticular class of expr and get it's fields 
  String print(Expr expr) {
    return expr.accept(this);
  }

  // Print Binary expressions
  @Override
  public String visitBinaryExpr(Expr.Binary expr) {
    return parenthesize(expr.operator.lexeme,
                        expr.left, expr.right);
  }

  // Print Grouping expressions
 @Override
  public String visitGroupingExpr(Expr.Grouping expr) {
    return parenthesize("group", expr.Expression);
  }

  // Print Literal expressions
  @Override
  public String visitLiteralExpr(Expr.Literal expr) {
    if (expr.value == null) return "nil";
    return expr.value.toString();
  }

  // Print Unary expressions
  @Override
  public String visitUnaryExpr(Expr.Unary expr) {
    return parenthesize(expr.operator.lexeme, expr.right);
  }

  // Format the given name and expressions using parenthesis
  private String parenthesize(String name, Expr... exprs) {
    StringBuilder builder = new StringBuilder();

    builder.append("(").append(name);
    for (Expr expr: exprs) {
      builder.append(" ");
      builder.append(expr.accept(this));
    }
    builder.append(")");

    return builder.toString();
  }

  // // Testing the ASTprinter
  // public static void main(String[] args) {
  //   Expr expression = new Expr.Binary(
  //     new Expr.Unary(new Token(TokenType.MINUS, "-", null, 1), new Expr.Literal(123)),
  //     new Token(TokenType.STAR, "*", null, 1),
  //     new Expr.Grouping(new Expr.Literal(45.67))
  //   );

  //   System.out.println(new AstPrinter().print(expression));
  // }
 }
