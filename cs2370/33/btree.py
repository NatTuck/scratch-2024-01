
class Leaf:
    def __str__(self):
        return "()"

    def __repr__(self):
        return self.__str__()

    def isLeaf(self):
        return True

    def contains(self, xx):
        return False

leaf = Leaf()


class Branch:
    def __init__(self, left, data, right):
        self.left = left
        self.data = data
        self.right = right

    def __str__(self):
        return f"({self.left} {self.data} {self.right})"

    def __repr__(self):
        return self.__str__()

    def isLeaf(self):
        return False

    def contains(self, xx):
        if xx == self.data:
            return True

        if xx < self.data:
            return self.left.contains(xx)
        else:
            return self.right.contains(xx)

aa = Branch(Branch(leaf, 1, leaf), 3, Branch(leaf, 5, Branch(leaf, 7, leaf)))


# (BinaryTree of Number) -> Number
# Add up all the numbers in the tree.
def sum(tree):
    if tree.isLeaf():
        return 0
    else:
        return sum(tree.left) + tree.data + sum(tree.right)


# (BinaryTree of Number) -> (BinaryTree of Number)
# Add one to each branch in the tree.
def add1_to_all(tree):
    if tree.isLeaf():
        return leaf
    else:
        return Branch(
            add1_to_all(tree.left),
            tree.data + 1,
            add1_to_all(tree.right))

def pluralize_all(tree):
    if tree.isLeaf():
        return leaf
    else:
        return Branch(
            pluralize_all(tree.left),
            pluralize(tree.data),
            pluralize_all(tree.right))

def tree_map(op, tree):
    if tree.isLeaf():
        return leaf
    else:
        return Branch(
            tree_map(op, tree.left),
            op(tree.data),
            tree_map(op, tree.right))



fs = Branch(
        Branch(
            Branch(leaf, "Apple", leaf),
            "Banana",
            Branch(leaf, "Canteloupe", leaf)),
        "Orange",
        Branch(
            Branch(leaf, "Papaya", leaf),
            "Pineapple",
            Branch(leaf, "Starfruit", leaf)))

def pluralize(st):
    return st + "s"
                

def tree_reduce(op, default, tree):
    if tree.isLeaf():
        return default
    else:
        # We have a Cons
        lv = tree_reduce(op, default, tree.left)
        rv = tree_reduce(op, default, tree.right)
        return op(lv, tree.data, rv)



