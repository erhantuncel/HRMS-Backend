DROP SCHEMA public CASCADE;
CREATE SCHEMA public; 

CREATE TABLE public.users
(
    id integer NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(60) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidates
(
    user_id integer NOT NULL,
    identity_number character(11) NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    date_of_birth date NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.employers
(
    user_id integer NOT NULL,
    company_name character varying(255) NOT NULL,
    web_page character varying(50) NOT NULL,
    phone character varying(12) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.staffs
(
    user_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE public.confirmations
(
    id integer NOT NULL,
    is_confirmed boolean NOT NULL,
    confirmed_date date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.staff_confirmations
(
    confirmation_id integer NOT NULL,
    staff_id integer NOT NULL,
    employer_id integer NOT NULL,
    PRIMARY KEY (confirmation_id)
);

CREATE TABLE public.email_confirmations
(
    confirmation_id integer NOT NULL,
    code character(10) NOT NULL,
    PRIMARY KEY (confirmation_id)
);

CREATE TABLE public.candidate_email_confirmations
(
    email_confirmation_id integer NOT NULL,
    candidate_id integer NOT NULL,
    PRIMARY KEY (email_confirmation_id)
);

CREATE TABLE public.employer_email_confirmations
(
    email_confirmation_id integer NOT NULL,
    employer_id integer NOT NULL,
    PRIMARY KEY (email_confirmation_id)
);

CREATE TABLE public.job_positions
(
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.users
    ADD CONSTRAINT "uk_users"
    UNIQUE ("email");


ALTER TABLE public.candidates
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.candidates
    ADD CONSTRAINT "uk_candidates"
    UNIQUE ("identity_number");


ALTER TABLE public.employers
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD CONSTRAINT "uk_employers"
    UNIQUE ("phone");


ALTER TABLE public.staffs
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.email_confirmations
    ADD FOREIGN KEY (confirmation_id)
    REFERENCES public.confirmations (id)
    NOT VALID;


ALTER TABLE public.staff_confirmations
    ADD FOREIGN KEY (confirmation_id)
    REFERENCES public.confirmations (id)
    NOT VALID;


ALTER TABLE public.candidate_email_confirmations
    ADD FOREIGN KEY (email_confirmation_id)
    REFERENCES public.email_confirmations (confirmation_id)
    NOT VALID;


ALTER TABLE public.candidate_email_confirmations
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (user_id)
    NOT VALID;


ALTER TABLE public.employer_email_confirmations
    ADD FOREIGN KEY (email_confirmation_id)
    REFERENCES public.email_confirmations (confirmation_id)
    NOT VALID;


ALTER TABLE public.employer_email_confirmations
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;


ALTER TABLE public.staff_confirmations
    ADD FOREIGN KEY (staff_id)
    REFERENCES public.staffs (user_id)
    NOT VALID;


ALTER TABLE public.staff_confirmations
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (user_id)
    NOT VALID;
    