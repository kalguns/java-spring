CREATE OR REPLACE FUNCTION get_department(p_pattern varchar)
returns table(
    employee_name varchar,
    employee_email varchar
)
language plpgsql
as
$$
begin
    return query
    select first_name,email
    from employees
    where department ilike p_pattern;
end;
$$

select * from get_department('%oth%');

DROP FUNCTION get_department(p_pattern varchar);