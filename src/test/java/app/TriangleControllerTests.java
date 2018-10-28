package app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TriangleControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkTriangleCaseScalene() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "1")
                .param("sideB", "2")
                .param("sideC", "3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.triangleType").value("Scalene Triangle"));
    }

    @Test
    public void checkTriangleCaseScalene1() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "1.1")
                .param("sideB", "2.2")
                .param("sideC", "3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.triangleType").value("Scalene Triangle"));
    }

    @Test
    public void checkTriangleCaseIsosceles() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "2")
                .param("sideB", "2")
                .param("sideC", "3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.triangleType").value("Isosceles triangle"));
    }

    @Test
    public void checkTriangleCaseIsosceles1() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "2")
                .param("sideB", "3")
                .param("sideC", "2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.triangleType").value("Isosceles triangle"));
    }

    @Test
    public void checkTriangleCaseIsosceles2() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "3")
                .param("sideB", "2")
                .param("sideC", "2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.triangleType").value("Isosceles triangle"));
    }

    @Test
    public void checkTriangleCaseEquilateral() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "2")
                .param("sideB", "2")
                .param("sideC", "2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.triangleType").value("Equilateral triangle"));
    }

    @Test
    public void checkTriangleCaseExceptional01() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "A")
                .param("sideB", "2")
                .param("sideC", "3"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void checkTriangleCaseExceptional02() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "1")
                .param("sideB", "2A")
                .param("sideC", "3"))
                .andDo(print()).andExpect(status().isBadRequest());
    }



    @Test
    public void checkTriangleCaseExceptional03() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "1")
                .param("sideB", "2")
                .param("sideC", "**"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void checkTriangleCaseExceptional04() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "")
                .param("sideB", "2")
                .param("sideC", "3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.triangleType").value("invalid"));
    }

    @Test
    public void checkTriangleCaseExceptional05() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "-1")
                .param("sideB", "2")
                .param("sideC", "3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.triangleType").value("invalid"));
    }

    @Test
    public void checkTriangleCaseExceptional06() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "-1")
                .param("sideB", "-1")
                .param("sideC", "3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.triangleType").value("invalid"));
    }

    @Test
    public void checkTriangleCaseExceptional07() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "0")
                .param("sideB", "1")
                .param("sideC", "3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.triangleType").value("invalid"));
    }

    @Test
    public void checkTriangleCaseExceptional08() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "99999999999999999999999999999999999999999999999999999999999999999")
                .param("sideB", "88888888888888888888888888888888888888888888888888888888888888888")
                .param("sideC", "3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.triangleType").value("Scalene Triangle"));
    }

    @Test
    public void checkTriangleCaseExceptional09() throws Exception {
        this.mockMvc.perform(get("/triangle")
                .param("sideA", "9.9.9")
                .param("sideB", "88888888888888888888888888888888888888888888888888888888888888888")
                .param("sideC", "3"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

}
