from .ASTNode import ASTNode


class CreateTableNode(ASTNode):
    def __init__(self, table_name, columns):
        self.table_name = table_name
        self.columns = columns

    def print(self, indent=0):
        print("  " * indent + f"CreateTable: {self.table_name}")
        for col in self.columns:
            col.print(indent + 1)
