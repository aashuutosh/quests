SELECT DISTINCT viewer_id As id
FROM Views
WHERE author_id=viewer_id
Order by viewer_id ASC