BEGIN TRY
    DECLARE @x INT = 5;

    UPDATE t
    SET t.val =
        CASE
            WHEN @x IN (1,2,3) THEN MAX(t.val)
            ELSE AVG(t.val)
        END
    FROM table1 t
    WHERE EXISTS (SELECT 1 FROM table2);

END TRY
BEGIN CATCH
    SELECT ERROR_MESSAGE();
END CATCH
