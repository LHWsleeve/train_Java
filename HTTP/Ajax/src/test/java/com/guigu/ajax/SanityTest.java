package com.guigu.ajax;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Rule;
import org.junit.Test;

import com.guigu.ajax.di.CoreModule;
import com.guigu.ajax.fixture.ContainerRule;

import com.amazonaws.services.ec2.AmazonEC2;

public class SanityTest {
	@Rule
	public ContainerRule containerRule = new ContainerRule(new CoreModule());
	
	@Inject
	AmazonEC2 amazonEC2;

	@Test
	public void sanityCheckTest() {
		assertNotNull(amazonEC2);
	}

}
