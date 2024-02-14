# 문제 : [PCCE 기출문제] 10번 / 데이터 분석
# 결과 :  / 속도: 0 / 메모리 : 0
# 제출시각 : 24-02-15  1:30:21
def solution(data, ext, val_ext, sort_by):
    dic = {
        "code": 0,
        "date": 1,
        "maximum": 2,
        "remain": 3
    }
    answer = []
    for _ in data :
        if _[dic[ext]] < val_ext:
            answer.append(_)

    return sorted(answer, key = lambda x: x[dic[sort_by]])
