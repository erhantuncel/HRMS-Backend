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
    identity_number character varying(11) NOT NULL,
    first_name character varying(25) NOT NULL,
    last_name character varying(25) NOT NULL,
    year_of_birth character varying(4) NOT NULL,
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

CREATE TABLE public.cities
(
    id int NOT NULL,
    name character varying(20) NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_cities PRIMARY KEY (id),
    CONSTRAINT uc_cities_name UNIQUE (name)
);

CREATE TABLE public.work_locations
(
    id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    name character varying(20) NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_work_locations PRIMARY KEY (id),
    CONSTRAINT uc_work_locations_name UNIQUE (name)
);

CREATE TABLE public.job_types
(
    id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    name character varying(20) NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_job_types PRIMARY KEY (id),
    CONSTRAINT uc_job_types_name UNIQUE (name)
);

CREATE TABLE public.job_adverts
(
    id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    employer_id int NOT NULL,
    job_position_id int NOT NULL,
    city_id int NOT NULL,
    work_location_id int NOT NULL,
    job_type_id int NOT NULL,
    job_definition text NOT NULL,
    min_salary double precision,
    max_salary double precision,
    open_position_count int NOT NULL,
    deadline date NOT NULL,
    is_active boolean NOT NULL, 
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_job_adverts PRIMARY KEY (id),
    CONSTRAINT fk_job_adverts_employers FOREIGN KEY (employer_id) REFERENCES public.employers (employer_id) ON DELETE CASCADE,
    CONSTRAINT fk_job_adverts_job_positions FOREIGN KEY (job_position_id) REFERENCES public.job_positions (id) ON DELETE CASCADE,
    CONSTRAINT fk_job_adverts_cities FOREIGN KEY (city_id) REFERENCES public.cities (id) ON DELETE CASCADE,
    CONSTRAINT fk_job_adverts_work_locations FOREIGN KEY (work_location_id) REFERENCES public.work_locations (id) ON DELETE CASCADE,
    CONSTRAINT fk_job_adverts_job_types FOREIGN KEY (job_type_id) REFERENCES public.job_types (id) ON DELETE CASCADE
);

CREATE TABLE public.staff_confirmations_job_advert
(
    job_advert_confirmation_id integer NOT NULL,
    job_advert_id int NOT NULL,
    CONSTRAINT pk_staff_confirmations_job_advert PRIMARY KEY (job_advert_confirmation_id),
    CONSTRAINT fk_staff_confirmations_job_advert_staff_confirmations FOREIGN KEY (job_advert_confirmation_id) REFERENCES public.staff_confirmations (id) ON DELETE CASCADE,
    CONSTRAINT fk_staff_confirmations_job_advert_job_adverts FOREIGN KEY (job_advert_id) REFERENCES public.job_adverts (id) ON DELETE CASCADE
);

CREATE TABLE public.photos
(
    id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    public_id character varying(50) NOT NULL,
    url character varying(250) NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_photos PRIMARY KEY (id),
    CONSTRAINT uc_photos_public_id UNIQUE (public_id),
    CONSTRAINT uc_photos_url UNIQUE (url)
);

CREATE TABLE public.resumes
(
    id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    candidate_id int NOT NULL,
    photo_id int,
    name character varying(30) NOT NULL,
    preface text NOT NULL,
    github_url character varying(50),
    linkedin_url character varying(50),
    skills character varying(300),
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_resumes PRIMARY KEY (id),
    CONSTRAINT fk_resumes_candidates FOREIGN KEY (candidate_id) REFERENCES public.candidates (candidate_id) ON DELETE CASCADE,
    CONSTRAINT fk_resumes_photos FOREIGN KEY (photo_id) REFERENCES public.photos (id) ON DELETE CASCADE
);

CREATE TABLE public.educations
(
    id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    resume_id int NOT NULL,
    school_name character varying(200) NOT NULL,
    department character varying(200) NOT NULL,
    start_date timestamp without time zone NOT NULL,
    end_date timestamp without time zone NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_educations PRIMARY KEY (id),
    CONSTRAINT fk_educations_resumes FOREIGN KEY (resume_id) REFERENCES public.resumes (id) ON DELETE CASCADE
);

CREATE TABLE public.job_experiences
(
    id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    job_position_id int NOT NULL,
    resume_id int NOT NULL,
    workplace_name character varying(200) NOT NULL,
    start_date timestamp without time zone NOT NULL,
    end_date timestamp without time zone NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_job_experiences PRIMARY KEY (id),
    CONSTRAINT fk_job_experiences_job_positions FOREIGN KEY (job_position_id) REFERENCES public.job_positions (id) ON DELETE CASCADE,
    CONSTRAINT fk_job_experiences_resumes FOREIGN KEY (resume_id) REFERENCES public.resumes (id) ON DELETE CASCADE
);

CREATE TABLE public.languages
(
    id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    resume_id int NOT NULL,
    name character varying(50) NOT NULL,
    level char(1) NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_languages PRIMARY KEY (id),
    CONSTRAINT fk_languages_resumes FOREIGN KEY (resume_id) REFERENCES public.resumes (id) ON DELETE CASCADE
);

CREATE TABLE public.skills
(
    id int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    name character varying(50) NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp without time zone NOT NULL,
    CONSTRAINT pk_skills PRIMARY KEY (id)
);


SET TIMEZONE='TURKEY';

-- Cities
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (1, 'ADANA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (2, 'ADIYAMAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (3, 'AFYON', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (4, 'A??RI', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (5, 'AMASYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (6, 'ANKARA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (7, 'ANTALYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (8, 'ARTV??N', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (9, 'AYDIN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (10, 'BALIKES??R', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (11, 'B??LEC??K', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (12, 'B??NG??L', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (13, 'B??TL??S', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (14, 'BOLU', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (15, 'BURDUR', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (16, 'BURSA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (17, '??ANAKKALE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (18, '??ANKIRI', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (19, '??ORUM', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (20, 'DEN??ZL??', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (21, 'D??YARBAKIR', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (22, 'ED??RNE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (23, 'ELAZI??', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (24, 'ERZ??NCAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (25, 'ERZURUM', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (26, 'ESK????EH??R', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (27, 'GAZ??ANTEP', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (28, 'G??RESUN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (29, 'G??M????HANE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (30, 'HAKKAR??', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (31, 'HATAY', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (32, 'ISPARTA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (33, 'MERS??N', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (34, '??STANBUL', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (35, '??ZM??R', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (36, 'KARS', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (37, 'KASTAMONU', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (38, 'KAYSER??', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (39, 'KIRKLAREL??', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (40, 'KIR??EH??R', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (41, 'KOCAEL??', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (42, 'KONYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (43, 'K??TAHYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (44, 'MALATYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (45, 'MAN??SA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (46, 'KAHRAMANMARA??', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (47, 'MARD??N', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (48, 'MU??LA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (49, 'MU??', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (50, 'NEV??EH??R', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (51, 'N????DE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (52, 'ORDU', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (53, 'R??ZE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (54, 'SAKARYA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (55, 'SAMSUN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (56, 'S????RT', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (57, 'S??NOP', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (58, 'S??VAS', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (59, 'TEK??RDA??', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (60, 'TOKAT', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (61, 'TRABZON', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (62, 'TUNCEL??', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (63, '??ANLIURFA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (64, 'U??AK', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (65, 'VAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (66, 'YOZGAT', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (67, 'ZONGULDAK', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (68, 'AKSARAY', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (69, 'BAYBURT', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (70, 'KARAMAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (71, 'KIRIKKALE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (72, 'BATMAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (73, '??IRNAK', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (74, 'BARTIN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (75, 'ARDAHAN', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (76, 'I??DIR', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (77, 'YALOVA', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (78, 'KARAB??K', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (79, 'K??L??S', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (80, 'OSMAN??YE', true, CURRENT_TIMESTAMP);
INSERT INTO public.cities (id, name, is_active, created_date) VALUES (81, 'D??ZCE', true, CURRENT_TIMESTAMP);
-- Job Positions
INSERT INTO public.job_positions(name, is_active, created_date) VALUES ('Backend Geli??tirici', true, CURRENT_TIMESTAMP);
INSERT INTO public.job_positions(name, is_active, created_date) VALUES ('Frontend Geli??tirici', true, CURRENT_TIMESTAMP);
INSERT INTO public.job_positions(name, is_active, created_date) VALUES ('Yaz??l??m Mimar??', true, CURRENT_TIMESTAMP);
INSERT INTO public.job_positions(name, is_active, created_date) VALUES ('Yaz??l??m Uzman??', true, CURRENT_TIMESTAMP);
-- Work Types
INSERT INTO public.work_locations (name, is_active, created_date) VALUES ('Ofis', true, CURRENT_TIMESTAMP);
INSERT INTO public.work_locations (name, is_active, created_date) VALUES ('Uzak', true, CURRENT_TIMESTAMP);
-- Work Times
INSERT INTO public.job_types (name, is_active, created_date) VALUES ('Tam Zamanl??', true, CURRENT_TIMESTAMP);
INSERT INTO public.job_types (name, is_active, created_date) VALUES ('Yar?? Zamanl??', true, CURRENT_TIMESTAMP);
-- Skills
INSERT INTO public.skills(name, is_active, created_date) VALUES ('Java', true, CURRENT_TIMESTAMP);
INSERT INTO public.skills(name, is_active, created_date) VALUES ('C#', true, CURRENT_TIMESTAMP);
INSERT INTO public.skills(name, is_active, created_date) VALUES ('Angular', true, CURRENT_TIMESTAMP);
INSERT INTO public.skills(name, is_active, created_date) VALUES ('React', true, CURRENT_TIMESTAMP);