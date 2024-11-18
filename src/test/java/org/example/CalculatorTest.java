package org.example;

import java.util.stream.Stream;
import net.bytebuddy.asm.Advice.Argument;
import static org.assertj.core.api.Assertions.*;
import org.example.calculate.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CalculatorTest {

    @DisplayName("덧셈 연산을 수행한다.")
    @Test
    void additionTestex(){

        int result = Calculator.calculate(1, "+", 2);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 수행한다.")
    @Test
    void subtractionTestex(){

        int result = Calculator.calculate(1, "-", 2);
        assertThat(result).isEqualTo(-1);
    }

    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void additionTest(PositiveNumber operand1, String oparator, PositiveNumber operand2, int result){

        int calculateResult = Calculator.calculate(operand1, oparator, operand2);
        assertThat(result).isEqualTo(calculateResult);
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
            arguments(1, "+", 2, 3),
            arguments(1, "-", 2, -1),
            arguments(4, "*", 2, 8),
            arguments(4, "/", 2, 2)
        );
    }

    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생")
    @Test
    void calculateExceptionTest(){
        assertThatCode(() -> Calculator.calculate(10, "/", 0))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
