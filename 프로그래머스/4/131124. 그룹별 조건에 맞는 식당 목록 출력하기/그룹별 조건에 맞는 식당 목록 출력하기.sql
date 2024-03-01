select b.MEMBER_NAME, a.REVIEW_TEXT, DATE_FORMAT(a.REVIEW_DATE, "%Y-%m-%d") as REVIEW_DATE
from REST_REVIEW a
join MEMBER_PROFILE b on a.MEMBER_ID = b.MEMBER_ID
where b.MEMBER_ID = (
    select MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
    order by COUNT(MEMBER_ID) desc
    limit 1
)
order by a.REVIEW_DATE, a.REVIEW_TEXT