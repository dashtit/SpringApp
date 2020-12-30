package com.titowecz.appList;

import com.titowecz.appList.Repository.UserRepository;
import com.titowecz.appList.models.Document;
import com.titowecz.appList.services.impl.UserServiceImpl;
import org.junit.Assert;
import com.titowecz.appList.Repository.CommentRepository;
import com.titowecz.appList.Repository.DocumentRepository;
import org.hamcrest.Matchers;
import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ApplicationSpringTests {

	@MockBean
	private DocumentRepository documentRepository;

	@MockBean
	private CommentRepository commentRepository;

	@MockBean
	private UserRepository userRepository;

	@Autowired
    UserServiceImpl userService;

	@Autowired
	WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@WithMockUser(username = "w")
	public void getAllDocuments() throws Exception {
		setUp();
		List<Document> documents = Arrays.asList(
				new Document("xc","zxc"),
				new Document("asd","asd1")
		);

		when(documentRepository.findAll()).thenReturn(documents);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/documents"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(2)))
				.andExpect(jsonPath("$[*].description", Matchers.containsInAnyOrder("zxc", "asd1")))
				.andExpect(jsonPath("$[*].title", Matchers.containsInAnyOrder("xc", "asd")));
	}


  @Test
  void existsUserByUserName() {
    try {
      Assert.assertTrue(userService.isExistUsername("user2"));
    } catch (ServiceException e) {
      e.printStackTrace();
    }
		}

	@Test
	void existsUserByEmail() {
		try {
			Assert.assertTrue(userService.isExistEmail("d.titowecz@yandex.ru"));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}


}
