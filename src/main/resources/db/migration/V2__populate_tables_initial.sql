
insert
	into
	public.author
(id,
	public_id,
	"name",
	country_of_birth,
	date_of_birth,
	created_at,
	updated_at)
values(nextval('author_id_seq'::regclass),
uuid_generate_v4(),
'William Shakespeare',
'England',
TO_DATE('26/04/1564', 'DD/MM/YYYY'),
now(),
now());

insert
	into
	public.book
(id,
	public_id,
	title,
	author_id,
	description,
	created_at,
	updated_at)
values(nextval('book_id_seq'::regclass),
uuid_generate_v4(),
'Hamlet',
1,
'Hamlet is melancholy, bitter, and cynical, full of hatred for his uncles scheming and disgust for his mothers sexuality. A reflective and thoughtful young man who has studied at the University of Wittenberg, Hamlet is often indecisive and hesitant, but at other times prone to rash and impulsive acts.',
now(),
now());

insert
	into
	public.bookshelf
(id,
	public_id,
	book_id,
	shelf_location,
	is_available,
	created_at,
	updated_at)
values(nextval('bookshelf_id_seq'::regclass),
uuid_generate_v4(),
1,
'Hall A - shelf 2 - planks 2',
true,
now(),
now());
