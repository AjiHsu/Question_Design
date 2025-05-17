# Insert Empty Cell

##### 2025/05/16 by aji hsu

##### level: hard

---
You are given an initial array `arr` of integers and a sequence of operations `operations`
and `numbers` (`operations.length == numbers.length`),
where `operations[i]` is either `"insert"` or `"query"`.  

* "insert": Insert `numbers[i][1]` empty cells at the position `numbers[i][0]`.
* "query": Return the value at a given index `numbers[i][0]`.

You need to return an array `result`, where `result.length = operations.length`.
* `result[i] = -1` if `operations[i] == "insert"` or the given query index is empty cell.
* `result[i]` is the value of the given index, otherwise.

---

Sample Input  
```text
arr = [10, 20, 30, 40]`  
operations = ["insert","insert","query","query","query","query","query","query","query","query","query"]
numbers = [[1, 2], [6, 3], [0, -1], [1, -1], [2, -1], [3, -1], [4, -1], [5, -1], [6, -1], [7, -1], [8, -1], [9, -1]]
```

Sample Output
```text
result = [-1, -1, 10, -1, -1, 20, 30, 40, -1, -1, -1, -1]
```

---