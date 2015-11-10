package com.earl.fishshop.daoImpl;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.CommentDao;
import com.earl.fishshop.pojo.CommentPo;


/**
 * 
 * 
 */
@Repository("commentDao")
public class CommentDaoImpl extends BaseDaoImpl<CommentPo> implements CommentDao {

}