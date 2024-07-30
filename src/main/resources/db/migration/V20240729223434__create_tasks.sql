CREATE TABLE tm_tasks(
    id BIGINT primary key not null,
    name VARCHAR(255) not null,
    CONSTRAINT fk_tm_types_id
                     FOREIGN KEY (type_id)
                     REFERENCES tm_tasks(id),
    CONSTRAINT fk_tm_status_id
                     FOREIGN KEY (status_id)
                     REFERENCES tm_types(id),
    CONSTRAINT fk_tm_priority_id
                     FOREIGN KEY (priority_id)
                     REFERENCES tm_priority(id)
);