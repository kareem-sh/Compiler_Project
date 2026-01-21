# ast_printer.py

from ast_nodes import ASTNode

def print_ast(node, indent=0):
    pad = "  " * indent

    if node is None:
        print(pad + "None")
        return

    cls = node.__class__.__name__
    print(f"{pad}{cls}")

    for attr, value in vars(node).items():
        print(f"{pad}  {attr}:")
        if isinstance(value, list):
            for item in value:
                print_ast(item, indent + 2)
        elif isinstance(value, ASTNode):
            print_ast(value, indent + 2)
        else:
            print(f"{pad}    {value}")
