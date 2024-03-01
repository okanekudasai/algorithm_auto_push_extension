-- 코드를 입력하세요
# select b.MEMBER_NAME, a.REVIEW_TEXT, a.REVIEW_DATE
# from REST_REVIEW a
# join MEMBER_PROFILE b on a.MEMBER_ID = b.MEMBER_ID
# where b.MEMBER_ID = (
# )
# order by a.REVIEW_DATE, a.REVIEW_TEXT


# select MEMBER_ID, count(MEMBER_ID)
# from REST_REVIEW
# group by MEMBER_ID
# where count(MEMBER_ID) = (
# select max(A) from 
# (    ) a
# )
# order by count(MEMBER_ID) desc


# with A as 
# (
    # select count(MEMBER_ID) as CNT
    # from REST_REVIEW
    # group by MEMBER_ID
    # order by count(MEMBER_ID) desc
    # limit 1
# )
# select b.MEMBER_NAME, a.REVIEW_TEXT, a.REVIEW_DATE
# from REST_REVIEW a, A
# join MEMBER_PROFILE b on a.MEMBER_ID = b.MEMBER_ID
# where b.MEMBER_ID in A.MEMBER_ID
# order by a.REVIEW_DATE, a.REVIEW_TEXT

select i.MEMBER_NAME, a.REVIEW_TEXT, DATE_FORMAT(a.REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
from REST_REVIEW a, (select MEMBER_ID
    from (
        select MEMBER_ID, COUNT(MEMBER_ID) as CCC, CNT
        from (
            select count(MEMBER_ID) as CNT
            from REST_REVIEW
            group by MEMBER_ID
            order by count(MEMBER_ID) desc
            limit 1
        ) a, REST_REVIEW b
        group by MEMBER_ID
    ) as b
where CCC = CNT) c, MEMBER_PROFILE i
where c.MEMBER_ID = a.MEMBER_ID and i.MEMBER_ID = a.MEMBER_ID
order by REVIEW_DATE, REVIEW_TEXT