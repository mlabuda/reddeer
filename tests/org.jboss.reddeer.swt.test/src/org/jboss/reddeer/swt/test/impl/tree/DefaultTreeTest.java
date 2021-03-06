/******************************************************************************* 
 * Copyright (c) 2016 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/ 
package org.jboss.reddeer.swt.test.impl.tree;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.jboss.reddeer.swt.api.TreeItem;
import org.jboss.reddeer.swt.impl.tree.DefaultTree;
import org.junit.Before;
import org.junit.Test;

public class DefaultTreeTest extends AbstractTreeTest {

	protected org.jboss.reddeer.swt.api.Tree tree;
	
	@Override
	protected void createControls(Shell shell) {
		super.createControls(shell);
	}
	
	@Before
	public void initTree(){
		tree = new DefaultTree();
	}

	@Test
	public void testColumnCount() {
		createTreeItems(tree.getSWTWidget());

		DefaultTree dt = new DefaultTree();

		assertTrue(String.format("DefaultTree should have %d columns, %d reported",
				TREE_COLUMN_COUNT, dt.getColumnCount()), dt.getColumnCount() == TREE_COLUMN_COUNT);
	}

	@Test
	public void testColumnHeaders() {
		createTreeItems(tree.getSWTWidget());
		
		DefaultTree defaultTree = new DefaultTree();
		
		List<String> headerColumns = defaultTree.getHeaderColumns();
		
		assertTrue("Default tree columns were not obtained correctly. Headers should be [Column1, Column2, Column3] "
				+ "but they were " + headerColumns.toString(), headerColumns.get(0).equals("Column1") &&
				headerColumns.get(1).equals("Column2") && headerColumns.get(2).equals("Column3"));
	}
	
	@Test
	public void testGetItems_noItems() {
		List<TreeItem> items = tree.getItems();
		assertTrue(items.isEmpty());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetItems() {
		createTreeItems(tree.getSWTWidget());
		List<TreeItem> items = tree.getItems();

		assertThat(items.size(), is(3));
		assertThat(items, hasItems(item("A"), item("B"), item("C")));
	}

	@Test
	public void testGetAllItems_noItems(){
		removeTreeItems(tree.getSWTWidget());
		List<TreeItem> items = tree.getAllItems();
		assertTrue(items.isEmpty());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetAllItems(){
		createTreeItems(tree.getSWTWidget());
		List<TreeItem> items = tree.getAllItems();
		assertThat(items.size(), is(7));
		assertThat((Iterable<TreeItem>) items, hasItems(
				item("A"), item("AA"), item("AAA"), item("AAB"), 
				item("B"), item("BB"), 
				item("C")));
	}
	
	private TypeSafeMatcher<TreeItem> item(final String text){
		return new TypeSafeMatcher<TreeItem>() {

			@Override
			public void describeTo(Description description) {
			}

			@Override
			protected boolean matchesSafely(TreeItem item) {
				return item.getText().equals(text);
			}
		};
	}
}
