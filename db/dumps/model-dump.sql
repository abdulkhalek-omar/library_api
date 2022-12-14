libraryDB: schema
    + tables
        address: table
            + columns
                id: bigint(20) NN
                address_line_1: varchar(255)
                address_line_2: varchar(255)
                city: varchar(150)
                postal_code: varchar(10)
                street: varchar(150)
                country_id: int(11)
            + keys
                #1: PK (id) (underlying index PRIMARY)
            + foreign-keys
                country_id_fk: foreign key (country_id) -> country (id)
        address_id_sequence: table
            + columns
                next_not_cached_value: bigint(21) NN
                minimum_value: bigint(21) NN
                maximum_value: bigint(21) NN
                start_value: bigint(21) NN
                    --  start value when sequences is created or value if RESTART is used
                increment: bigint(21) NN
                    --  increment value
                cache_size: bigint(21) unsigned NN
                cycle_option: tinyint(1) unsigned NN
                    --  0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed
                cycle_count: bigint(21) NN
                    --  How many cycles have been done
        author: table
            + columns
                id: bigint(20) NN
                birth_date: datetime(6)
                cv: varchar(255)
                first_name: varchar(100) NN
                last_name: varchar(150) NN
            + keys
                #1: PK (id) (underlying index PRIMARY)
        author_id_sequence: table
            + columns
                next_not_cached_value: bigint(21) NN
                minimum_value: bigint(21) NN
                maximum_value: bigint(21) NN
                start_value: bigint(21) NN
                    --  start value when sequences is created or value if RESTART is used
                increment: bigint(21) NN
                    --  increment value
                cache_size: bigint(21) unsigned NN
                cycle_option: tinyint(1) unsigned NN
                    --  0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed
                cycle_count: bigint(21) NN
                    --  How many cycles have been done
        book: table
            + columns
                id: bigint(20) NN
                description: varchar(255)
                isbn: varchar(255)
                number_of_page: int(11)
                publish_at: datetime(6)
                title: varchar(200) NN
                author_id: bigint(20)
                category_id: bigint(20)
                language_id: int(11)
                publisher_id: bigint(20)
            + keys
                #1: PK (id) (underlying index PRIMARY)
            + foreign-keys
                author_id_fk: foreign key (author_id) -> author (id)
                category_id_fk: foreign key (category_id) -> category (id)
                language_id_fk: foreign key (language_id) -> language (id)
                publisher_id_fk: foreign key (publisher_id) -> publisher (id)
        book_id_sequence: table
            + columns
                next_not_cached_value: bigint(21) NN
                minimum_value: bigint(21) NN
                maximum_value: bigint(21) NN
                start_value: bigint(21) NN
                    --  start value when sequences is created or value if RESTART is used
                increment: bigint(21) NN
                    --  increment value
                cache_size: bigint(21) unsigned NN
                cycle_option: tinyint(1) unsigned NN
                    --  0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed
                cycle_count: bigint(21) NN
                    --  How many cycles have been done
        category: table
            + columns
                id: bigint(20) NN
                category_name: varchar(150) NN
            + keys
                #1: PK (id) (underlying index PRIMARY)
        category_id_sequence: table
            + columns
                next_not_cached_value: bigint(21) NN
                minimum_value: bigint(21) NN
                maximum_value: bigint(21) NN
                start_value: bigint(21) NN
                    --  start value when sequences is created or value if RESTART is used
                increment: bigint(21) NN
                    --  increment value
                cache_size: bigint(21) unsigned NN
                cycle_option: tinyint(1) unsigned NN
                    --  0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed
                cycle_count: bigint(21) NN
                    --  How many cycles have been done
        country: table
            + columns
                id: int(11) NN
                country_name: varchar(150) NN
            + keys
                #1: PK (id) (underlying index PRIMARY)
                UK_qrkn270121aljmucrdbnmd35p: AK (country_name)
        country_id_sequence: table
            + columns
                next_not_cached_value: bigint(21) NN
                minimum_value: bigint(21) NN
                maximum_value: bigint(21) NN
                start_value: bigint(21) NN
                    --  start value when sequences is created or value if RESTART is used
                increment: bigint(21) NN
                    --  increment value
                cache_size: bigint(21) unsigned NN
                cycle_option: tinyint(1) unsigned NN
                    --  0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed
                cycle_count: bigint(21) NN
                    --  How many cycles have been done
        language: table
            + columns
                id: int(11) NN
                iso_639_1: varchar(2)
            + keys
                #1: PK (id) (underlying index PRIMARY)
        language_id_sequence: table
            + columns
                next_not_cached_value: bigint(21) NN
                minimum_value: bigint(21) NN
                maximum_value: bigint(21) NN
                start_value: bigint(21) NN
                    --  start value when sequences is created or value if RESTART is used
                increment: bigint(21) NN
                    --  increment value
                cache_size: bigint(21) unsigned NN
                cycle_option: tinyint(1) unsigned NN
                    --  0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed
                cycle_count: bigint(21) NN
                    --  How many cycles have been done
        loan: table
            + columns
                id: bigint(20) NN
                loan_data: datetime(6) NN
                return_data: datetime(6) NN
                book_id: bigint(20)
                user_id: bigint(20)
            + keys
                #1: PK (id) (underlying index PRIMARY)
                user_book_unique: AK (user_id, book_id)
            + foreign-keys
                book_id_fk: foreign key (book_id) -> book (id)
                user_id_fk: foreign key (user_id) -> user (id)
        loan_id_sequence: table
            + columns
                next_not_cached_value: bigint(21) NN
                minimum_value: bigint(21) NN
                maximum_value: bigint(21) NN
                start_value: bigint(21) NN
                    --  start value when sequences is created or value if RESTART is used
                increment: bigint(21) NN
                    --  increment value
                cache_size: bigint(21) unsigned NN
                cycle_option: tinyint(1) unsigned NN
                    --  0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed
                cycle_count: bigint(21) NN
                    --  How many cycles have been done
        publisher: table
            + columns
                id: bigint(20) NN
                publisher_name: varchar(255) NN
            + keys
                #1: PK (id) (underlying index PRIMARY)
        publisher_id_sequence: table
            + columns
                next_not_cached_value: bigint(21) NN
                minimum_value: bigint(21) NN
                maximum_value: bigint(21) NN
                start_value: bigint(21) NN
                    --  start value when sequences is created or value if RESTART is used
                increment: bigint(21) NN
                    --  increment value
                cache_size: bigint(21) unsigned NN
                cycle_option: tinyint(1) unsigned NN
                    --  0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed
                cycle_count: bigint(21) NN
                    --  How many cycles have been done
        user: table
            + columns
                id: bigint(20) NN
                email: varchar(150) NN
                first_name: varchar(100) NN
                last_name: varchar(150) NN
                phone: varchar(15)
                user_role: varchar(255)
            + keys
                #1: PK (id) (underlying index PRIMARY)
                email_unique: AK (email)
                phone_unique: AK (phone)
        user_address: table
            + columns
                user_id: bigint(20) NN
                address_id: bigint(20) NN
            + keys
                #1: PK (address_id, user_id) (underlying index PRIMARY)
            + foreign-keys
                user_id_address_fk: foreign key (user_id) -> user (id)
                address_id_user_fk: foreign key (address_id) -> address (id)
        user_id_sequence: table
            + columns
                next_not_cached_value: bigint(21) NN
                minimum_value: bigint(21) NN
                maximum_value: bigint(21) NN
                start_value: bigint(21) NN
                    --  start value when sequences is created or value if RESTART is used
                increment: bigint(21) NN
                    --  increment value
                cache_size: bigint(21) unsigned NN
                cycle_option: tinyint(1) unsigned NN
                    --  0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed
                cycle_count: bigint(21) NN
                    --  How many cycles have been done
