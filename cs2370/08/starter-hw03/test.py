#!/usr/bin/env python

import runpy
import io
import sys
from glob import glob
from copy import deepcopy


def main():
    print("1..10")
    script = find_script()
    mod = safe_import(script)

    def see(name):
        return name in mod and type(mod[name]) == type(main)
    
    if see('move_mosquito'):
        ok(eq(mod['move_mosquito']((25, 8)), (28, 8)), "mosquito forward")
        ok(eq(mod['move_mosquito']((799, 400)), (2, 400)), "mosquito wrap")
    else:
        ok(False, "no move_mosquito function")

    if see('bat_caught_mosquito'):
        ok(eq(mod['bat_caught_mosquito'](25, (18, 25)), False), "bat miss")
        ok(eq(mod['bat_caught_mosquito'](110, (507, 105)), True), "bat hit")
    else:
        ok(False, "no bat_caught_mosquito")

    if see('bat_eat_any_nearby_bugs'):
        bugs = [(100, 100), (517, 200), (400, 400), (500, 493)]

        bs1 = mod['bat_eat_any_nearby_bugs'](100, bugs)
        ok(eq(bugs, bs1), "bat missed them all")

        bs2 = mod['bat_eat_any_nearby_bugs'](197, bugs)
        ex2 = deepcopy(bugs)
        ok(neq(ex2[1], bs2[1]), "bat got bugs[1]")
        bs2[1:2] = []
        ex2[1:2] = []
        ok(eq(ex2, bs2), "the rest are unchanged")
    else:
        ok(False, "no bat_eat_any_nearby_bugs")

    
    ok(see('move_bat'), "move_bat function exists")
    ok(see('new_mosquito'), "new_mosquito function exists")


def eq(aa, bb):
    if aa != bb:
        print(f"# '{aa}' != '{bb}'")
    return aa == bb

            
def neq(aa, bb):
    if aa == bb:
        print(f"# '{aa}' == '{bb}', which is bad")
    return aa != bb

            
def safe_import(script):
    default_stdout = sys.stdout
    sys.stdout = io.StringIO()
    mod = runpy.run_path(script)
    text = sys.stdout.getvalue()
    sys.stdout = default_stdout
    ok(text == "", "No excess output from top-level statements")
    return mod

    
def find_script():
    pys = glob("*.py")
    for py in pys:
        if py != "test.py":
            return py
    bail("No program to test found (it should be named 'something.py')")


def bail(msg):
    print("#")
    print("# The test script crashed, with the following message:")
    print("#")
    print("#    ", msg)
    print("#")
    sys.exit(1)

    
test_num = 1

def ok(passed, msg):
    global test_num

    if passed:
        print("ok", test_num, "-", msg)
    else:
        print("not ok", test_num, "-", msg)

    test_num += 1

    
if __name__ == '__main__':
    main()
