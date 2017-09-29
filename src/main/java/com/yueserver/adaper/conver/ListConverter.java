package com.yueserver.adaper.conver;

import com.yueserver.adaper.MethodNourtFoundException;
import com.yueserver.adaper.encryption.base64.Base64;
import com.yueserver.enity.User;
import com.yueserver.enity.Brand;
import com.yueserver.enity.Merchant;
import com.yueserver.enity.PrdPic;
import com.yueserver.enity.Product;
import com.yueserver.enity.Post;

import javax.servlet.http.HttpSession;
import java.util.*;

import static com.yueserver.adaper.AdaperFactory.getSingleAdaperFactory;
import static com.yueserver.controller.LoginController.getPrincipal;

public class ListConverter {

    /**
     * 格式化 productlist
     * @param productlist
     * @param session
     * @return
     */
    public List setPrdList(List productlist, HttpSession session){
        ArrayList jsonlist = new ArrayList();
        List brandlist = new ArrayList();
        for (Iterator<Object> iterator = productlist.iterator(); iterator.hasNext();){
            Brand brand = (Brand) iterator.next();
            brandlist.add(brand);
            Iterator<Product> productIterator = brand.getProducts().iterator();
            while (productIterator.hasNext()){
                HashMap prdmap = new HashMap();
                if (getPrincipal().getAuthorities().equals("ROLE_ADMIN")) {
                    Product product = productIterator.next();
                    prdmap.put("no", product.getPrdno());
                    prdmap.put("prdname", product.getPrdname());
                    prdmap.put("prdcapacity", product.getPrdcapacity());
                    prdmap.put("brdname", product.getBrand().getBrdname());
                    prdmap.put("prdcode", product.getPrdcode());
                    prdmap.put("prdprice", product.getPrdprice());
                    prdmap.put("prdintro", product.getPrdintro());
                    prdmap.put("prdpic", setPrdPicList(product.getPrdpics()));
                }
                else {
                    Product product = productIterator.next();
                    prdmap.put("no", product.getPrdno());
                    prdmap.put("prdname", product.getPrdname());
                    prdmap.put("prdcapacity", product.getPrdcapacity());
                    prdmap.put("brdname", product.getBrand().getBrdname());
                    prdmap.put("prdcode", product.getPrdcode());
                    prdmap.put("prdpic", setPrdPicList(product.getPrdpics()));
                    prdmap.put("prdintro", product.getPrdintro());
                    prdmap.put("prdprice", product.getPrdprice());
                }
                jsonlist.add(prdmap);
            }
        }
        session.setAttribute("brdlist", setBrdList(brandlist));
        return jsonlist;
    }

    /**
     * 格式化商品图片list
     * @param prdpicset
     * @return
     */
    public String setPrdPicList(Set<PrdPic> prdpicset){
        PrdPic[] prdPics = prdpicset.toArray(new PrdPic[prdpicset.size()]);
        String prdpicurl = "<img class=\"img-rounded\" width=\"150em\" height=\"auto\" src=\"";
        for (int i = 0; i < prdPics.length; i ++){
            if (i < prdPics.length - 1)
                prdpicurl += prdPics[i].getPrdpicurl() + "\"/>"
                        +
                        "<img class=\"img-rounded\" width=\"150em\" height=\"auto\" src=\"";
            else
                prdpicurl += prdPics[i].getPrdpicurl();
        }
        return prdpicurl + "\">";
    }

    /**
     * 格式化 brandlist
     * @param brandlist
     * @return
     */
    public List setBrdList(List brandlist){
        ArrayList jsonlist = new ArrayList();
        for (Iterator<Brand> iterator = brandlist.iterator(); iterator.hasNext();){
            Brand brand = iterator.next();
            HashMap brdmap = new HashMap();
            brdmap.put("no", brand.getBrdno());
            brdmap.put("brdname", brand.getBrdname());
            brdmap.put("brdintro", brand.getBrdintro());
            brdmap.put("brdlogo", brand.getBrdlogo());
            jsonlist.add(brdmap);
        }
        return jsonlist;
    }

    /**
     * 格式化 userlist
     * @param userlist
     * @return
     */
    public List setUserList(List userlist){
        ArrayList jsonlist = new ArrayList();
        for (Iterator<User> iterator = userlist.iterator(); iterator.hasNext();) {
            User user = iterator.next();
            HashMap usermap = new HashMap();
            usermap.put("no", user.getUserno());
            usermap.put("username", user.getUsrname());
            usermap.put("userimg", user.getUserimage());
            usermap.put("userintro", user.getUserintro());
            usermap.put("userstatus", user.getUsrname());
            jsonlist.add(usermap);
        }
        return jsonlist;
    }

    /**
     * 格式化 postlist
     * @param postlist
     * @return
     */
    public List setPostList(List postlist){
        ArrayList jsonlist = new ArrayList();
        for (Iterator<Post> iterator = postlist.iterator(); iterator.hasNext();) {
            Post post = iterator.next();
            HashMap postmap = new HashMap();
            postmap.put("no", post.getPostno());
            postmap.put("posttitle", post.getPosttitle());
            postmap.put("postmain", post.getPostmain());
            postmap.put("posttime", post.getPosttitle());
            jsonlist.add(postmap);
        }
        return jsonlist;
    }

    /**
     * 格式化 merchantlist
     * @param merchantlist
     * @return
     */
    public List setSellerList(List merchantlist){
        ArrayList jsonlist = new ArrayList();
        for (Iterator<Merchant> iterator = merchantlist.iterator(); iterator.hasNext();){
            Merchant merchant = iterator.next();
            HashMap mctmap = new HashMap();
            mctmap.put("no", merchant.getMctno());
            mctmap.put("mctaccount", getBase64().Base64Decode(merchant.getMctaccount()));
            mctmap.put("time", String.valueOf(merchant.getMcttime()));
            if (merchant.getMctstate() == 1) {
                mctmap.put("mctstate", "可登录");
                jsonlist.add(mctmap);
                continue;
            }
            if (merchant.getMctstate() == 0) {
                mctmap.put("mctstate", "待审核");
                jsonlist.add(mctmap);
                continue;
            }
            if (merchant.getMctstate() == -1) {
                mctmap.put("mctstate", "被禁止");
                jsonlist.add(mctmap);
                continue;
            }
        }
        return jsonlist;
    }

    public List<List> HotPostList(List<List> hotList) {
        List<List> list = new ArrayList<>();
        for (Iterator iterator = hotList.iterator(); iterator.hasNext();) {

        }
        return null;
    }

    private Base64 getBase64() {
        try {
            return (Base64) getSingleAdaperFactory().getEncryption("Base64");
        } catch (MethodNourtFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
