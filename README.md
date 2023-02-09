# Knights Shortest Path

The problem being solved is finding the minimum number of moves for the Knight chess piece to move to reach a given point on an infinite chess board.

The knight piece can only move in the following ways.
- +/- 1 on x axis, +/- 2 on y axis
- +/- 2 on x axis, +/- 1 on y axis

In solving this problem, existing alogorithms and data structures were researched including,
- Brute Force
- Dijkstra's Algorithm
- A* Algorithm

The most applicable in this case was an implementation of a brute force using a breadth-first search. Two different methods to this were implemented and compared in terms of time complexity (Big O).

The second improved method was considerably better at finding far away points to be found, where the original would run out of memory.
## Run Locally

Clone the project

```bash
  git clone https://github.com/EthanPeacock/knights-shortest-path
```

Open the folder using an IDE, in this case `intelliJ IDEA` was used.

Run the `Algo` file.