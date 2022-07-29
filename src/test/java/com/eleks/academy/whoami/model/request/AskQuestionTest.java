package com.eleks.academy.whoami.model.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AskQuestionTest {
        Validator validator;

        @BeforeEach
        public void setUp() {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();
        }

        @ParameterizedTest
        @CsvSource({"This text message has 257 symbols and is created for checking is of the maximum length limit of the question is valid that the player can input in the game. So sorry for a next text. fbvnalbegbaigbalregbuaybgaghbylihrgnvilaerhbgvauyekrhgnrkeguiaubpidd-256+1,Question length must be limited in 256 symbols!, Question length must be limited in 256 symbols!",
                "'  ',Message must not be blank and not null!"})
        void questionAnnotationsValidationTest(String question, String message) {
            Message q = new Message();
            q.setMessage(question);
            Set<ConstraintViolation<Message>> violations = validator.validate(q);

            assertEquals(message, violations.stream().findFirst().get().getMessage());
        }

    }
