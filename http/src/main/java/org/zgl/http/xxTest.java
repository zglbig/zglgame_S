package org.zgl.http;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @作者： big
 * @创建时间： 2018/6/11
 * @文件描述：
 */
@Controller
@RequestMapping("/")
public class xxTest {
    @RequestMapping("/yy")
    private void xx(HttpServletRequest request) throws IOException {
        System.out.println(request.getInputStream());
        System.out.println("xx");
    }
}
