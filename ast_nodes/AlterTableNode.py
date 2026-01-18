# ast_nodes/AlterTableNode.py
from .ASTNode import ASTNode


class AlterTableNode(ASTNode):
    def __init__(self, table, columns):
        self.table = table
        self.columns = columns

    def print(self, indent=0):
        print("  "*indent + f"AlterTable: {self.table}")
        for col in self.columns:
            col.print(indent+1)


# ast_nodes/UpdateNode.py


class UpdateNode(ASTNode):
    def __init__(self, table, assignments, where=None):
        self.table = table
        self.assignments = assignments
        self.where = where

    def print(self, indent=0):
        print("  "*indent + f"Update: {self.table}")
        for col, val in self.assignments:
            print("  "*(indent+1) + f"{col} = {val}")
        if self.where:
            self.where.print(indent+1)


# ast_nodes/DeclareNode.py


class DeclareNode(ASTNode):
    def __init__(self, name, datatype):
        self.name = name
        self.datatype = datatype

    def print(self, indent=0):
        print("  "*indent + f"Declare: {self.name} {self.datatype}")


# ast_nodes/BlockNode.py


class BlockNode(ASTNode):
    def __init__(self, statements):
        self.statements = statements

    def print(self, indent=0):
        print("  "*indent + "Begin/End Block:")
        for stmt in self.statements:
            stmt.print(indent+1)


class IfNode(ASTNode):
    def __init__(self, condition, then_block, else_block=None):
        self.condition = condition
        self.then_block = then_block
        self.else_block = else_block

    def print(self, indent=0):
        print("  "*indent + f"If condition: {self.condition}")
        print("  "*indent + "Then:")
        self.then_block.print(indent+1)
        if self.else_block:
            print("  "*indent + "Else:")
            self.else_block.print(indent+1)
