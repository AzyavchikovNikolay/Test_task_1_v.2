package by.htp.ex.dao.impl;

import by.htp.ex.bean.News;
import java.util.ArrayList;
import java.util.List;
import by.htp.ex.dao.INewsDAO;
import by.htp.ex.dao.NewsDAOException;

public class NewsDAO implements INewsDAO {

	@Override
	public List<News> getLatestsList(int count) throws NewsDAOException{
		List<News> result = new ArrayList<News>();
		
		result.add(new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "content1", "30/12/2022"));
		result.add(new News(2, "title2", "brief2brief2brief2brief2brief2brief2brief2", "content2", "30/12/2022"));
		result.add(new News(3, "title3", "brief3brief3brief3brief3brief3brief3brief3", "content3", "30/12/2022"));
		result.add(new News(4, "title4", "brief4brief4brief4brief4brief4brief4brief4", "content4", "30/12/2022"));
		result.add(new News(5, "title5", "brief5brief5brief5brief5brief5brief5brief5", "content5", "30/12/2022"));
		
		return result;
	}
	
	@Override
	public List<News> getList() throws NewsDAOException{
		List<News> result = new ArrayList<News>();
		
		result.add(new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "content1", "30/12/2022"));
		result.add(new News(2, "title2", "brief2brief2brief2brief2brief2brief2brief2", "content2", "30/12/2022"));
		result.add(new News(3, "title3", "brief3brief3brief3brief3brief3brief3brief3", "content3", "30/12/2022"));
		result.add(new News(4, "title4", "brief4brief4brief4brief4brief4brief4brief4", "content4", "30/12/2022"));
		result.add(new News(5, "title5", "brief5brief5brief5brief5brief5brief5brief5", "content5", "30/12/2022"));
		
		return result;
	}
	
	@Override
	public News fetchById(int id) throws NewsDAOException{
		
		List<News> result = new ArrayList<News>();
		News uRes=null;
		
		result.add(new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "content1", "30/12/2022"));
		result.add(new News(2, "title2", "brief2brief2brief2brief2brief2brief2brief2", "content2", "30/12/2022"));
		result.add(new News(3, "title3", "brief3brief3brief3brief3brief3brief3brief3", "content3", "30/12/2022"));
		result.add(new News(4, "title4", "brief4brief4brief4brief4brief4brief4brief4", "content4", "30/12/2022"));
		result.add(new News(5, "title5", "brief5brief5brief5brief5brief5brief5brief5", "content5", "30/12/2022"));
		
		for(News u:result) {
			if(id==u.getIdNews()) {
				uRes=u;
				break;
			}	
		}
		return uRes;
	}
	
	@Override
	public void addNews(News news) throws NewsDAOException{
		
		List<News> result = new ArrayList<News>();
		result.add(new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "content1", "30/12/2022"));
		result.add(new News(2, "title2", "brief2brief2brief2brief2brief2brief2brief2", "content2", "30/12/2022"));
		result.add(new News(3, "title3", "brief3brief3brief3brief3brief3brief3brief3", "content3", "30/12/2022"));
		result.add(new News(4, "title4", "brief4brief4brief4brief4brief4brief4brief4", "content4", "30/12/2022"));
		result.add(new News(5, "title5", "brief5brief5brief5brief5brief5brief5brief5", "content5", "30/12/2022"));
		
		int id = news.getIdNews();
		String title = news.getTitle();
		String brief = news.getBriefNews();
		String content = news.getContent();
		String date = news.getNewsDate();
		
		result.add(new News(id, title, brief, content, date));
		
	}
	
	@Override
	public void updateNews(News news) throws NewsDAOException{
		
		List<News> result = new ArrayList<News>();
		result.add(new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "content1", "30/12/2022"));
		result.add(new News(2, "title2", "brief2brief2brief2brief2brief2brief2brief2", "content2", "30/12/2022"));
		result.add(new News(3, "title3", "brief3brief3brief3brief3brief3brief3brief3", "content3", "30/12/2022"));
		result.add(new News(4, "title4", "brief4brief4brief4brief4brief4brief4brief4", "content4", "30/12/2022"));
		result.add(new News(5, "title5", "brief5brief5brief5brief5brief5brief5brief5", "content5", "30/12/2022"));
		
		int id = news.getIdNews();
		for(News n:result) {
			if(id==n.getIdNews()) {
				n.setTitle(news.getTitle());
				n.setNewsDate(news.getNewsDate());
				n.setBriefNews(news.getBriefNews());
				n.setContent(news.getContent());
				break;
			}
		}
	}
	
	@Override
	public void deleteNews(int idNews) throws NewsDAOException{
		
		List<News> result = new ArrayList<News>();
		
		result.add(new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "content1", "30/12/2022"));
		result.add(new News(2, "title2", "brief2brief2brief2brief2brief2brief2brief2", "content2", "30/12/2022"));
		result.add(new News(3, "title3", "brief3brief3brief3brief3brief3brief3brief3", "content3", "30/12/2022"));
		result.add(new News(4, "title4", "brief4brief4brief4brief4brief4brief4brief4", "content4", "30/12/2022"));
		result.add(new News(5, "title5", "brief5brief5brief5brief5brief5brief5brief5", "content5", "30/12/2022"));
		
		for(News u:result) {
			if(idNews==u.getIdNews()) {
				//delete news
				break;
			}	
		}
	}
	
	@Override
	public void deleteNewses(String[] idNewses) throws NewsDAOException{
		
		List<News> result = new ArrayList<News>();
		
		result.add(new News(1, "title1", "brief1brief1brief1brief1brief1brief1brief1", "content1", "30/12/2022"));
		result.add(new News(2, "title2", "brief2brief2brief2brief2brief2brief2brief2", "content2", "30/12/2022"));
		result.add(new News(3, "title3", "brief3brief3brief3brief3brief3brief3brief3", "content3", "30/12/2022"));
		result.add(new News(4, "title4", "brief4brief4brief4brief4brief4brief4brief4", "content4", "30/12/2022"));
		result.add(new News(5, "title5", "brief5brief5brief5brief5brief5brief5brief5", "content5", "30/12/2022"));
		
		for(String id:idNewses) {
			for(News u:result) {
				if(Integer.valueOf(id)==u.getIdNews()) {
					//delete news
				}	
			}
		}	
	}
}
