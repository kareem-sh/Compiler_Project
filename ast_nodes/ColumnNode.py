from .ASTNode import ASTNode


class ColumnNode(ASTNode):
    def __init__(self, name, datatype=None):
        self.name = name
        self.datatype = datatype

    def print(self, indent=0):
        if self.datatype:
            print("  " * indent + f"Column: {self.name} {self.datatype}")
        else:
            print("  " * indent + f"Column: {self.name}")
