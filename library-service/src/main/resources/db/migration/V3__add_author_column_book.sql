--- alter table

ALTER TABLE BOOK ADD COLUMN author varchar(255);

--- insert records to the new column

UPDATE BOOK SET author = 'Michael C. Feathers' WHERE ID = 1;
UPDATE BOOK SET author = 'Ralph Johnson, Erich Gamma, John Vlissides, and Richard Helm' WHERE ID = 2;
UPDATE BOOK SET author = 'Robert C. Martin' WHERE ID = 3;