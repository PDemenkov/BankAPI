create table user(
                     id int primary key auto_increment,
                     name varchar(255),
                     surname varchar(255),
);
create table account(
                        id int primary key auto_increment,
                        account_number varchar(255),
                        balance int
);
create table card(
                     id int primary key auto_increment,
                     card_number varchar(255),
                     cvv varchar(3),
                     exp_date varchar(255)
);
create table counter_party(
                              id int primary key auto_increment,
                              name varchar(255)
);