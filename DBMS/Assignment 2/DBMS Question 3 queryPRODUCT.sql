SELECT t.topcategoryname AS TOP_CATEGORY ,s.supercategoryname AS PARENT_CATEGORY,c.categoryname AS CATEGORIES,sc.subcategoryname AS SUBCATEGORIES
FROM topcategory T 
LEFT OUTER JOIN supercategory s ON  s.topcategory_ID=t.topcategory_ID 
LEFT OUTER JOIN category c ON c.supercategory_ID=s.supercategory_ID   
LEFT OUTER JOIN subcategory sc ON sc.category_ID=c.category_ID
ORDER BY t.topcategoryname ;



SELECT topcategoryname AS NAME FROM topcategory;

