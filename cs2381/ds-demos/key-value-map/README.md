
# Map Structures

## General Concept

Store a collection of values associated with keys.

Simplest idea: store a collection of key/value pairs.

Example:

animal_noises = {
    "cow": "moo",
    "sheep": "baa",
    "horse": "neigh",
}

animal_noises["pig"] = "oink"

## Association Lists

[("pig", "squeal"), ("pig", "oink"), ("cow", "moo"), ("sheep", "baa"), ("horse", "neigh")]

 - Handle duplicate keys by always scanning from the
   beginning of the list.

In Java:

```java
record Entry<K extends Comparable<K>, V>(K key, V val) {
    // empty
}

ArrayList<Entry<String, String>> map;
```

## TreeMap

Almost just a ```TreeSet<Entry<K, V>>```.

What needs to be different?

 - 


