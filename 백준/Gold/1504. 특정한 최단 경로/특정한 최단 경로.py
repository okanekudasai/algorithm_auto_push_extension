import heapq
import sys
input = sys.stdin.read
INF = int(1e9)

def dijkstra(start, n, graph):
    distance = [INF] * (n + 1)
    distance[start] = 0
    q = []
    heapq.heappush(q, (0, start))
    
    while q:
        dist, now = heapq.heappop(q)
        
        if dist > distance[now]:
            continue
        
        for next_node, weight in graph[now]:
            cost = dist + weight
            if cost < distance[next_node]:
                distance[next_node] = cost
                heapq.heappush(q, (cost, next_node))
    
    return distance

def solve():
    data = input().split()
    n = int(data[0])
    e = int(data[1])
    
    graph = [[] for _ in range(n + 1)]
    
    index = 2
    for _ in range(e):
        a = int(data[index])
        b = int(data[index + 1])
        c = int(data[index + 2])
        graph[a].append((b, c))
        graph[b].append((a, c))
        index += 3
    
    v1 = int(data[index])
    v2 = int(data[index + 1])
    
    # 1. 1번 정점에서 각 정점까지의 최단 거리
    dist_from_1 = dijkstra(1, n, graph)
    
    # 2. v1에서 각 정점까지의 최단 거리
    dist_from_v1 = dijkstra(v1, n, graph)
    
    # 3. v2에서 각 정점까지의 최단 거리
    dist_from_v2 = dijkstra(v2, n, graph)
    
    # 두 가지 경로 중 짧은 경로를 선택
    route1 = dist_from_1[v1] + dist_from_v1[v2] + dist_from_v2[n]
    route2 = dist_from_1[v2] + dist_from_v2[v1] + dist_from_v1[n]
    
    # 둘 중 하나라도 경로가 INF이면 갈 수 없는 경로임
    if dist_from_1[v1] == INF or dist_from_v1[v2] == INF or dist_from_v2[n] == INF:
        route1 = INF
    if dist_from_1[v2] == INF or dist_from_v2[v1] == INF or dist_from_v1[n] == INF:
        route2 = INF
    
    result = min(route1, route2)
    
    # 경로가 없는 경우 -1 출력
    if result >= INF:
        print(-1)
    else:
        print(result)

# solve() 호출 추가
solve()