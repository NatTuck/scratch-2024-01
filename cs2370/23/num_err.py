
from functools import total_ordering

# ±

@total_ordering
class NumErr:
    """Represents a number with uncertainty (val±err)."""

    def __init__(self, val, err = 0):
        if isinstance(val, NumErr):
            self.val = val.val
            self.err = val.err
        else:
            self.val = val
            self.err = err

    def __add__(self, yy):
        yy = NumErr(yy)
        return NumErr(self.val + yy.val, self.err + yy.err)

    def __radd__(self, yy):
        return self + yy

    def __sub__(self, yy):
        yy = NumErr(yy)
        return NumErr(self.val - yy.val, self.err + yy.err)

    def frac_err(self):
        return self.err / abs(self.val)

    def __mul__(self, yy):
        yy = NumErr(yy)
        val = self.val * yy.val
        # FIXME: Still slightly wrong
        err = abs(val * (self.frac_err() + self.frac_err()))
        return NumErr(val, err)

    def __truediv__(self, yy):
        yy = NumErr(yy)
        val = self.val / yy.val
        # FIXME: Still slightly wrong
        # Assumption: Dividing by zero is still bad
        err = abs(val * (self.frac_err() + self.frac_err()))
        return NumErr(val, err)

    def __repr__(self):
        return f"NumErr({self.val}, {self.err})"

    def __str__(self):
        return f"{self.val}±{self.err}"

    def __eq__(self, yy):
        err = self.err + yy.err
        return self.val + err >= yy.val and self.val - err <= yy.val

    def __lt__(self, yy):
        return self.val < yy.val



class Thing:
    pass

aa = Thing()
aa.height = 5

bb = { 'height': 22 }

height = 7

def foo():
    # Declare new variable
    zz = 23

    # Modify object, but variable
    # still points to same object
    bb['height'] = 43

foo()

print(bb['height'])



















