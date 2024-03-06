
ArrayQueue example:

This is a ring buffer

Initial object:

```
    B = 0
    F = 0
    data = [null, null]
```

Insert letters, A, B, C, D, E, F, G, H, I, J

```
    B = 1
    F = 0
    data = [A, null]
```

```
    B = 2
    F = 0
    data = [A, B]
```

```
    B = 3
    F = 0
    data = [A, B, C, null]
    data0= [A, B]
```

Shift A, B:

```
    B = 3
    F = 2
    data = [A, B, C, null]
```

Same data:

```
    B = 3
    F = 2
    data = [null, null, C, null]
```



Push D, E:

```
    B = 4
    F = 2
    data = [A, B, C, D]
```

Push D, E:

```
    B = 1
    F = 2
    data = [E, null, C, D]
```

Push F, G

```
    B = 2
    F = 2
    data = [E, F, C, D]
```

Grow before pushing G

```
    B = 4
    F = 0
    data = [C, D, E, F, null, null, null, null]
```

Push G

```
    B = 5
    F = 0
    data = [C, D, E, F, G, null, null, null]
```

Deque

```
    B = 5
    F = 0
    data = [C, D, E, F, G, null, null, null]
```

ConsDeque

Push A-G

```
front = []
back = [G, F, E, D, C, B, A]
```

Shift A-C,

```
front = [D, E, F, G]
back = []
```

Push H-K

```
front = [D, E, F, G]
back = [K, J, I, H]
```

Pop 5 items:

```
front = []
back = [F, E, D]
```

Shift 1 item

```
front = [E, F]
back = []
```





































