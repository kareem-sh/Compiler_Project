from .ASTNode import ASTNode


class SelectNode(ASTNode):
    def __init__(self, columns=None, table=None, where=None, order_by=None):
        self.columns = columns or []      # list of column names (strings)
        self.table = table                # table name (string) or None
        self.where = where                # WhereNode or None
        # list of tuples [(column, direction), ...]
        self.order_by = order_by or []

    def print(self, indent=0):
        print("  " * indent + "Select")
        print("  " * (indent + 1) + "Columns:")
        if self.columns:
            for col in self.columns:
                print("  " * (indent + 2) + col)
        else:
            print("  " * (indent + 2) + "(None)")

        print("  " * (indent + 1) +
              f"From: {self.table if self.table else '(None)'}")

        if self.where:
            self.where.print(indent + 1)

        if self.order_by:
            print("  " * (indent + 1) + "Order By:")
            for col, direction in self.order_by:
                print("  " * (indent + 2) + f"{col} {direction}")
