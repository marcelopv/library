CREATE SEQUENCE book_id_seq;
ALTER TABLE book ALTER COLUMN id SET DEFAULT nextval('book_id_seq');
ALTER SEQUENCE book_id_seq OWNED BY book.id;