package www.wanfin.com.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class ExcelController {
	/*@RequestMapping(value = { "export" })
	public String export(HttpServletRequest request, HttpServletResponse response,Model model) {
		try {
			try {
				String title = "";
				List<TestVo> teamList =new ArrayList<TestVo>();
				TestVo vo=new TestVo();
				vo.setCustomerId("1");
				vo.setCustomerId("aaa");
				teamList.add(vo);
				title = "数据";
				String fileName = title+ ".xlsx";
				new ExportExcel(title, TestVo.class).setDataList(teamList).write(response, fileName).dispose();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
}
