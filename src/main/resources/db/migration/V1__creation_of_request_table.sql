CREATE TABLE requests(
    id_request varchar(255) UNIQUE NOT NULL PRIMARY KEY,
    date_request timestamp NOT NULL,
    name_archive_request varchar(255) not null,
    method_payment_request varchar(255) not null,
    status_payment varchar(255) not null
);