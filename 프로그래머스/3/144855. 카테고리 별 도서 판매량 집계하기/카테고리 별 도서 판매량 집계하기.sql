-- 코드를 입력하세요
SELECT BOOK.CATEGORY, sum(BOOK_SALES.SALES) as TOTAL_SALES from BOOK, BOOK_SALES
where BOOK.BOOK_ID = BOOK_SALES.BOOK_ID and month(BOOK_SALES.SALES_DATE) = 1
group by BOOK.CATEGORY
order by BOOK.CATEGORY;