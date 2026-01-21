from .ASTNode import ASTNode


class WhereNode(ASTNode):
    def __init__(self, left, op, right):
        self.left = left
        self.op = op
        self.right = right

    def print(self, indent=0):
        print("  " * indent + f"Where: {self.left} {self.op} {self.right}")
