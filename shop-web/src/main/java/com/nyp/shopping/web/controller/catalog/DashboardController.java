/**
 * 
 */
package com.nyp.shopping.web.controller.catalog;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nyp.shopping.catalog.service.DashboardService;


/**
 * @author Praveen
 *
 */
@Controller
@RequestMapping("/")
public class DashboardController {

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

	@Inject
	private DashboardService dashboardService;

	public DashboardController() {
	}

	public DashboardService getDashboardService() {
		return dashboardService;
	}

	public void setDashboardService(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
	}

	@RequestMapping("/")
	public String init(Model model, HttpServletRequest request) {

		logger.info("Init DashboardController Invoked");
		//Map<ProductCategory, Set<ProductCategory>> productCategoryMap = dashboardService.getProductCategoryMap(null);
		//model.addAttribute(productCategoryMap);
		//request.setAttribute("productCategoryMap", productCategoryMap);
		return "sc.dashboard";
	}

	@RequestMapping("/loaddeptmenu/{deptId}")
	public String loadDeptMenu(Model model, HttpServletRequest request, @PathVariable Long deptId){

		logger.info("Load dept menu DashboardController Invoked for "+deptId);
		/*Map<ProductCategory, Set<ProductCategory>> productCategoryMap = (Map<ProductCategory, Set<ProductCategory>>)request.getServletContext().getAttribute("productCategoryMapCtx");
		//Map<ProductCategory, Set<ProductCategory>> productCategoryMap = dashboardService.getProductCategoryMap(deptId);
		model.addAttribute(productCategoryMap);
		Object selectedProductCategory = new ProductCategory(deptId);
		request.setAttribute("productCategoryList", productCategoryMap.get(selectedProductCategory));

		Iterator<ProductCategory> iterator = productCategoryMap.keySet().iterator();
		while(iterator.hasNext()) {
			ProductCategory key = iterator.next();
			if(key.equals(selectedProductCategory)) {
				selectedProductCategory = key;
			}
		}
		
		request.setAttribute("selectedDept", selectedProductCategory);
		request.setAttribute("deptId", deptId);*/
		return "sc.dashboard.deptSelected";
	}

	@RequestMapping("/loaddeptmenu/{deptId}/{catId}")
	public String loadDeptAndCategoryMenu(Model model, HttpServletRequest request, @PathVariable Long deptId, @PathVariable Long catId) {

		logger.info("Load dept menu DashboardController Invoked for "+deptId);
		/*Map<ProductCategory, Set<ProductCategory>> productCategoryMap = (Map<ProductCategory, Set<ProductCategory>>)request.getServletContext().getAttribute("productCategoryMapCtx");
		//Map<ProductCategory, Set<ProductCategory>> productCategoryMap = dashboardService.getProductCategoryMap(deptId);
		model.addAttribute(productCategoryMap);
		ProductCategory selectedProductDept = new ProductCategory(deptId);
		request.setAttribute("productCategoryList", productCategoryMap.get(selectedProductDept));

		Iterator<ProductCategory> iterator = productCategoryMap.keySet().iterator();
		while(iterator.hasNext()) {
			ProductCategory key = iterator.next();
			if(key.equals(selectedProductDept)) {
				selectedProductDept = key;
			}
		}
		request.setAttribute("one", selectedProductDept.getParentCategory());
		if(null!=selectedProductDept.getParentCategory()) {
			request.setAttribute("one", selectedProductDept.getParentCategory());
			if(null!=selectedProductDept.getParentCategory().getParentCategory()) {
				request.setAttribute("two", selectedProductDept.getParentCategory().getParentCategory());
				if(null!=selectedProductDept.getParentCategory().getParentCategory().getParentCategory()) {
					request.setAttribute("three", selectedProductDept.getParentCategory().getParentCategory().getParentCategory());
				}
			}
		}
		request.setAttribute("selectedDept", selectedProductDept);
		request.setAttribute("deptId", deptId);	*/
		return "sc.dashboard.deptSelected";
	}

	@RequestMapping("/loaddeptmenu/{deptId}/{catId}/abc")
	public String loadDeptAndCategoryAndProductMenu(Model model, HttpServletRequest request, @PathVariable Long deptId, @PathVariable Long catId){

		logger.info("Load dept menu DashboardController Invoked for "+deptId);
		/* Map<ProductCategory, Set<ProductCategory>> productCategoryMap = (Map<ProductCategory, Set<ProductCategory>>)request.getServletContext().getAttribute("productCategoryMapCtx");
		//Map<ProductCategory, Set<ProductCategory>> productCategoryMap = dashboardService.getProductCategoryMap(deptId);
		model.addAttribute(productCategoryMap);
		ProductCategory selectedProductCategory = new ProductCategory(deptId);
		request.setAttribute("productCategoryList", productCategoryMap.get(selectedProductCategory));

		Iterator<ProductCategory> iterator = productCategoryMap.keySet().iterator();
		while(iterator.hasNext()) {
			ProductCategory key = iterator.next();
			if(key.equals(selectedProductCategory)) {
				selectedProductCategory = key;
			}
		}
		request.setAttribute("one", selectedProductCategory.getParentCategory());
		if(null!=selectedProductCategory.getParentCategory()) {
			request.setAttribute("one", selectedProductCategory.getParentCategory());
			if(null!=selectedProductCategory.getParentCategory().getParentCategory()) {
				request.setAttribute("two", selectedProductCategory.getParentCategory().getParentCategory());
				if(null!=selectedProductCategory.getParentCategory().getParentCategory().getParentCategory()) {
					request.setAttribute("three", selectedProductCategory.getParentCategory().getParentCategory().getParentCategory());
				}
			}
		}
		request.setAttribute("selectedDept", selectedProductCategory);
		request.setAttribute("deptId", deptId);*/
		return "sc.dashboard.deptSelected";
	}


	
	
	
}



