#Testing the Web Layer
## Spring boot from https://spring.io/guides/gs/testing-web/
- SpringBoot Application HomeController
- Simple sanity check to check application context loads
  @SpringBootTest
- Test the load of HomeController
  @SpringBootTest - @Test - @Autowired - AssertThat()
- Test HomeController with random port on Tomcat using TestRestTemplate
  @SpringBootTest - @LocalServerPort - @Autowired TestRestTemplate - @Test
- Mocking the HomeController, Tomcat not used, MockMvc
  @SpringBootTest - @AutoConfigureMockMvc - @Autowired MockMvc - @Test
  mockMvc.perform(get("/"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("response from controller")));
- Only WebLayer Test, Tomcat not used
  @WebMvcTest - @Autowired MockMvc - @Test   
  mockMvc.perform(get("/"))
              .andDo(print())
              .andExpect(status().isOk())
              .andExpect(content().string(containsString("response from controller")));
- A controller with his service to be more realistic, first injected with @Autowired
  after created by constructor so @Autowired not needed.