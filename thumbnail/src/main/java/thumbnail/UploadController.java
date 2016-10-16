package thumbnail;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 上传文件的Controller
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(name = "/")
public class UploadController {

	@RequestMapping("upload")
	public ModelAndView upload(HttpSession session, @RequestParam("image") CommonsMultipartFile file) {
		ModelAndView mv = new ModelAndView();
		String uploadPath = "/images";
		// 转化为绝对路径
		String realUploadPath = session.getServletContext().getRealPath("/image");
		String imageUrl = "";// 原图

		// 缩略图的访问路径
		String thumbnailUrl = "";// 缩略图
		thumbnailUrl = ThumbnailService.thumbnail(file, uploadPath, realUploadPath);
		mv.addObject("imageUrl", imageUrl);
		mv.addObject("thumbnailUrl", thumbnailUrl);

		mv.setViewName("thumbnail");
		return mv;
	}
}
