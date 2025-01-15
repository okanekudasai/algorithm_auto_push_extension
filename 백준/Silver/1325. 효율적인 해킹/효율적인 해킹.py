from collections import deque

def bfs(start, graph, visited):
    queue = deque([start])
    visited[start] = True
    count = 1
    
    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)
                count += 1
    return count

def solution():
    import sys
    input = sys.stdin.read
    data = input().splitlines()
    
    n, m = map(int, data[0].split())
    graph = [[] for _ in range(n + 1)]
    
    for i in range(1, m + 1):
        a, b = map(int, data[i].split())
        graph[b].append(a)  # 역방향 그래프
    
    max_hack = 0
    result = []
    
    for i in range(1, n + 1):
        visited = [False] * (n + 1)
        hack_count = bfs(i, graph, visited)
        if hack_count > max_hack:
            max_hack = hack_count
            result = [i]
        elif hack_count == max_hack:
            result.append(i)
    
    print(*result)

solution()