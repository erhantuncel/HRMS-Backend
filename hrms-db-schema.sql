DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE public.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    email character varying(50) NOT NULL,
    password character varying(60) NOT NULL,
    is_active boolean DEFAULT false NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT uc_users_email UNIQUE (email)
);

CREATE TABLE public.candidates
(
    candidate_id integer NOT NULL,
    identity_number character(11) NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    year_of_birth character(4) NOT NULL,
    CONSTRAINT pk_candidates PRIMARY KEY (candidate_id),
    CONSTRAINT fk_candidates_users FOREIGN KEY (candidate_id) REFERENCES public.users (id) ON DELETE CASCADE,
    CONSTRAINT uc_candidates_identity_number UNIQUE (identity_number)
);

CREATE TABLE public.employers
(
    employer_id integer NOT NULL,
    company_name character varying(255) NOT NULL,
    web_page character varying(50) NOT NULL,
    phone character varying(12) NOT NULL,
    CONSTRAINT pk_employers PRIMARY KEY (employer_id),
    CONSTRAINT fk_employers_users FOREIGN KEY (employer_id) REFERENCES public.users (id) ON DELETE CASCADE,
    CONSTRAINT uc_employers_phone UNIQUE (phone)
);

CREATE TABLE public.staffs
(
    staff_id integer NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    CONSTRAINT pk_staffs PRIMARY KEY (staff_id),
    CONSTRAINT fk_staffs_users FOREIGN KEY (staff_id) REFERENCES public.users (id) ON DELETE CASCADE
);

CREATE TABLE public.verification_codes
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    user_id integer NOT NULL,
    code character varying(38) NOT NULL,
    is_verified boolean DEFAULT false NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_verification_codes PRIMARY KEY (id),
    CONSTRAINT fk_verification_codes_users FOREIGN KEY (user_id) REFERENCES public.users (id) ON DELETE CASCADE,
    CONSTRAINT uc_verification_codes_code UNIQUE (code)
);

CREATE TABLE public.staff_confirmations
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    staff_id int NOT NULL,
    is_confirmed boolean DEFAULT false NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_staff_confirmations PRIMARY KEY (id),
    CONSTRAINT fk_staff_confirmations_staffs FOREIGN KEY (staff_id) REFERENCES public.staffs (staff_id) ON DELETE CASCADE
);

CREATE TABLE public.staff_confirmations_employer
(
    employer_confirmation_id integer NOT NULL,
    employer_id int NOT NULL,
    CONSTRAINT pk_staff_confirmations_employer PRIMARY KEY (employer_confirmation_id),
    CONSTRAINT fk_staff_confirmations_employer_staff_confirmations FOREIGN KEY (employer_confirmation_id) REFERENCES public.staff_confirmations (id) ON DELETE CASCADE,
    CONSTRAINT fk_staff_confirmations_employer_employers FOREIGN KEY (employer_id) REFERENCES public.employers (employer_id) ON DELETE CASCADE
);

CREATE TABLE public.job_positions
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    name character varying(50) NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_job_positions PRIMARY KEY (id),
    CONSTRAINT uc_job_positions_name UNIQUE (name)
);