package thumbnail;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;

public class ThumbnailService {

	// 缩略图的高度
	private static final int WIDTH = 100;
	private static final int HEIGHT = 100;
	// 缩略图的宽度

	public static String thumbnail(CommonsMultipartFile file, String uploadPath, String realLoadPath) {
		try {
			String dest = realLoadPath + "/thum_" + file.getOriginalFilename();
			// 缩略图实现类
			Thumbnails.of(file.getInputStream()).size(WIDTH, HEIGHT).toFile(dest);
		} catch (Exception e) {

		}

		return realLoadPath + "thum_" + file.getOriginalFilename();

	}
}
